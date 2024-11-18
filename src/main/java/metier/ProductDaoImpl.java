package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDaoImpl implements IDao<Product> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        return true;
    }

    @Override
    @Transactional
    public Product findById(int Id){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, Id);
        return product;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = (List<Product>) session.createCriteria(Product.class).list();
        return products;
    }
}
