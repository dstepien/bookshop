import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

  public static void main(String[] args) {
    Configuration config = new Configuration();
    config.configure("hibernate.cfg.xml");
    config.addAnnotatedClass(Book.class);

    persistBooks(config, 30);
    persistBooks(config, 30);

    System.out.println("Successfully saved");
    System.exit(0);
  }

  private static void persistBooks(Configuration config, int n) {
    Session session = config.buildSessionFactory().openSession();
    for(int i = 0; i < n; i++) {
      persistBook(session);
    }
    session.close();
  }

  private static void persistBook(Session session) {
    Transaction transaction = session.beginTransaction();
    Book book = new Book();
    book.setTitle("Java persistence");
    session.persist(book);
    transaction.commit();
  }
}
