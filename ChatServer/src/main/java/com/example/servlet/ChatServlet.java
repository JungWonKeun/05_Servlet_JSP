package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    // 채팅 메시지를 저장할 리스트 (서버 재시작 시 초기화)
    private List<String> messages = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트로부터 받은 메시지를 저장
        String message = request.getParameter("message");
        if (message != null && !message.trim().isEmpty()) {
            messages.add(message);
        }

        // 메시지 리스트를 다시 출력하기 위해 GET 요청으로 리다이렉트
        response.sendRedirect("chat");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // HTML 출력
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>잡담</h1>");

        // 저장된 메시지를 출력
        for (String message : messages) {
            response.getWriter().println("<p>" + message + "</p>");
        }

        // 입력 폼 출력
        response.getWriter().println("<form method='post' action='chat'>");
        response.getWriter().println("<input type='text' name='message' />");
        response.getWriter().println("<input type='submit' value='전송' />");
        response.getWriter().println("</form>");

        response.getWriter().println("</body></html>");
    }
}
