package ua.org.oa._dani4_.service.impl;

import ua.org.oa._dani4_.dao.Dao;
import ua.org.oa._dani4_.dao.daoImpl.UserDaoSqlImpl;
import ua.org.oa._dani4_.model.dto.UserDTO;
import ua.org.oa._dani4_.model.elements.User;
import ua.org.oa._dani4_.properties.PropertyUtils;
import ua.org.oa._dani4_.service.IUserService;
import ua.org.oa._dani4_.transform.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Admin on 03.04.2016.
 */
public class UserServiceImpl implements IUserService<UserDTO> {

    private static UserServiceImpl userService;
    private Dao<User> userDAO = fetchDAO();
    private UserServiceImpl() {   }
    private Dao<User> fetchDAO() {
        Dao<User> userDAO = null;
        Properties properties = PropertyUtils.getProperties();
        String value = properties.getProperty("DB");
        switch (value) {
            case "JDBC":
                userDAO = new UserDaoSqlImpl();
                break;
        }
        return userDAO;
    }

    public synchronized static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
    @Override
    public UserDTO findById(int id) {
        User userById = userDAO.read(id);
        return Transformer.transformUser(userById);
    }

    @Override
    public int create(UserDTO userDTO) {
        User user = Transformer.transformUserDTO(userDTO);
        return userDAO.create(user).getId();
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> users = new ArrayList<>();
        for (User user : userDAO.getAll()) {
            users.add(Transformer.transformUser(user));
        }
        return users;
    }

    @Override
    public boolean delete(int id) {
        return userDAO.delete(id);
    }


}