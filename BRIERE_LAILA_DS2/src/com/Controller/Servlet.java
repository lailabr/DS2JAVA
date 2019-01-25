package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Metier.Metier;





public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    Metier metier = new Metier();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String role=null;
		HttpSession session = request.getSession();
		if(action.equals("auth"))
		{
			Boolean result = metier.authentify(request);
			
			if(result)
			{
				role =metier.getRole();

				if(role.equals("Abonnee"))
				{
					session.setAttribute("abonnee", metier.getAbonnee(metier.getId()));
					
				}else if(role.equals("Agent"))
				{
					session.setAttribute("agent", metier.getAgent(metier.getId()));
					session.setAttribute("AllAbonnees", metier.getAllAbonnee());
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/"+role+".jsp").forward(request, response);
				
			
			
			}else {
				this.getServletContext().getRequestDispatcher("/authentifier.jsp").forward(request, response);
			}
			
			
		}else if(action.equals("Valider"))
		{
			Boolean exit = metier.VerifierCompte(request);
			if(exit)
			{
				metier.ValiderPayement(metier.getId());
				request.setAttribute("MessageErreur", "");
				this.getServletContext().getRequestDispatcher("/WEB-INF/Success.jsp").forward(request, response);
			}else {
				request.setAttribute("MessageErreur", "Payement Echouée");
				this.getServletContext().getRequestDispatcher("/WEB-INF/Abonnee.jsp").forward(request, response);
			}
			
		}else if(action.equals("Deconnecter"))
		{
			
			this.getServletContext().getRequestDispatcher("/authentifier.jsp").forward(request, response);
		}
	
	}

}
