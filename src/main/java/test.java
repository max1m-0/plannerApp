import daos.SampleServiceDAO;
import org.hibernate.SessionFactory;
import utils.MonthUtil;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;

public class test {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) throws ParseException {
        SampleServiceDAO sampleDAO = new SampleServiceDAO();
        int widthOfWindow = 1120;
        int heightOfWindow = 520;
        int	arcHeight = 15;
        int arcWidth = 15;
        int startXofWindow = (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfWindow)/2;
        int startYofWindow = (Toolkit.getDefaultToolkit ().getScreenSize ().height-heightOfWindow)/2;


        Jtable dialog = new Jtable(sampleDAO,sampleDAO.getTaskColumnCount(),sampleDAO.findAllEmployees(), MonthUtil.getMonthList(),MonthUtil.getDecemberDaysCount());
        dialog.setUndecorated(true);
        Dimension dimension = new Dimension();
        dimension.setSize(widthOfWindow,heightOfWindow);
        dialog.setLocation(startXofWindow,startYofWindow);
        RoundRectangle2D.Double roundRectangle = new RoundRectangle2D.Double(0,0,widthOfWindow,heightOfWindow,arcWidth,arcHeight);
        dialog.setShape(roundRectangle);
        dialog.setMinimumSize(dimension);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
