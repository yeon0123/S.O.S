package com.sos.signal.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/register-form")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    @ResponseBody
    @GetMapping("/admin-register")
    public ResponseEntity<Resource> joinform() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:templates/member/register_form.html");
        if (resource.exists()) {
            return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/signup")
    public String join(@ModelAttribute Admin admin,  @RequestParam("a_admin_type") String a_admin_type) {
        admin.setAdminType(a_admin_type);
        adminRepository.save(admin);
        return "member/login_form";
    }

    @PostMapping("/admin-signin")
    public String signIn(@RequestParam("email") String email, @RequestParam("pw") String pw) {
        List<Admin> admins = adminRepository.findMembers(email, pw);
        if (!admins.isEmpty()) {
            Admin admin = admins.get(0);
            Authentication authentication = new UsernamePasswordAuthenticationToken(admin, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            if (admin.getAdminType().equals("경찰")) {
                return "admin/police/admin_main_police";
            } else {
                return "admin/nonpolice/admin_main_nonpolice";
            }
        }
        return "member/login_form";
    }

    @GetMapping("/register-form/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return "common/main";
    }
}
