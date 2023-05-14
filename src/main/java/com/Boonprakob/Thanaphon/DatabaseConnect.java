package com.Boonprakob.Thanaphon;

import com.Boonprakob.Thanaphon.domain.StudentOfThanaphon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnect
{
    public static void main(String[] args)
    {
        try (final EntityManagerFactory emf = Persistence.createEntityManagerFactory("student"))
        {
            usageDemo(emf);
        }
    }
    private static void usageDemo (EntityManagerFactory emf)
    {
        try(final EntityManager em = emf.createEntityManager();)
        {
            //
//            StudentOfThanaphon st = new StudentOfThanaphon();
//            st.setId("2");
//            st.setName("Thanaphon");
            em.getTransaction().begin();
            StudentOfThanaphon[] st = new StudentOfThanaphon[3];
            for (int i = 0;i<3;i++)
            {
                st[i] = new StudentOfThanaphon();
                st[i].setId(String.valueOf(i+3));
                st[i].setName("Thanaphon"+String.valueOf(i));
                System.out.println(st[i].getName()+"   "+st[i].getId());
                em.persist(st[i]);
            }
//            em.persist(st);
            em.getTransaction().commit();
        }
    }
}
