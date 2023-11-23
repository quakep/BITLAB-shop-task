package servlets;

import db.CardItem;
import db.DBManager;
import db.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/card")
public class CardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/card.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Item item = DBManager.getItem(id);

        HttpSession session = req.getSession();
        ArrayList<CardItem> cardItems = (ArrayList<CardItem>) session.getAttribute("cardItems");

        if (cardItems == null) {
            cardItems= new ArrayList<>();
            CardItem cardItem = new CardItem(1, item);
            cardItems.add(cardItem);
        } else {
            boolean itemInCard = false;
            for (CardItem cardITEM : cardItems) {
                if (cardITEM.getItem().getId()==id) {
                    itemInCard = true;
                    cardITEM.setCount(cardITEM.getCount()+1);
                    break;
                }
            }

            if (!itemInCard) {
                CardItem cardItem2 = new CardItem(1, item);
                cardItems.add(cardItem2);
            }
        }

        session.setAttribute("cardItems", cardItems);
        resp.sendRedirect("/card");
    }
}