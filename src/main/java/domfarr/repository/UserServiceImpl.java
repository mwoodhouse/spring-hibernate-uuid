package domfarr.repository;

import domfarr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserServiceImpl implements UserService
{
    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserServiceImpl(final HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public User getUser(String id)
    {
        return (User) hibernateTemplate.get(User.class, id);
    }

    @Override @SuppressWarnings("unchecked")
    public List<User> getUsers()
    {
        return hibernateTemplate.find("from User u");
    }

    @Override
    public void saveOrUpdate(User user)
    {
        if (hibernateTemplate.contains(user))
        {
            hibernateTemplate.merge(user);
        }
        else
        {
            hibernateTemplate.saveOrUpdate(user);
        }
    }
}
