package com.ramq.Security;

import com.ramq.Dossier.Patient;
import com.ramq.Dossier.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        Utilisateur utilisateur = (Utilisateur) authentication.getPrincipal();

        String redirectURL;

        if (utilisateur.getRole() == (Utilisateur.Role.PATIENT)) {
            redirectURL = "patient";
        } else
            redirectURL = "medecin";
        response.sendRedirect(redirectURL);

    }
}
