package domfarr.repository;

import domfarr.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserServiceImpl implements UserService
{
    private SessionFactory sessionFactory;

    @Autowired
    public UserServiceImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUser(String id)
    {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override @SuppressWarnings("unchecked")
    public List<User> getUsers()
    {
        return sessionFactory.getCurrentSession().createQuery("from User u").list();
    }

    @Override
    public void saveOrUpdate(User user)
    {
        if (sessionFactory.getCurrentSession().contains(user))
        {
            sessionFactory.getCurrentSession().merge(user);
        }
        else
        {
            sessionFactory.getCurrentSession().saveOrUpdate(user);
        }
    }
}
