import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class DealerService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPersistenceUnit");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public boolean createDealerEntity(String dealerName, String dealerPassword){
        boolean isCreated = false;

        if(getDealerEntity(dealerName) == null) {

            DealerEntity newDealer = new DealerEntity();
            newDealer.setDealerEntityName(dealerName);
            newDealer.setDealerEntityPassword(dealerPassword);

            tx.begin();
            em.persist(newDealer);
            tx.commit();

            isCreated = true;
        }

        return isCreated;
    }

    public void deleteDealerEntity(String dealerName){
        DealerEntity dealerEntity = em.find(DealerEntity.class, dealerName);
        if(dealerEntity != null){

            tx.begin();
            em.remove(dealerEntity);
            tx.commit();

        }

    }


    DealerEntity getDealerEntity(String dealerName){
        return em.find(DealerEntity.class, dealerName);
    }

//    public ArrayList<DealerEntity> getDealersEntities(){
//        em.createQuery("SELECT d from DealerEntity d");
//    }
}
