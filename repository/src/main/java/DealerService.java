import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DealerService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public DealerEntity createDealer(String dealerName, String dealerPassword){
        DealerEntity newDealer = new DealerEntity();
        newDealer.setDealerName(dealerName);
        newDealer.setDealerPassword(dealerPassword);

        tx.begin();
        em.persist(newDealer);
        tx.commit();

        return newDealer;
    }

    public boolean deleteDealer(String dealerName){
        DealerEntity dealerEntity = em.find(DealerEntity.class, dealerName);
        return true;
    }
}
