package colval.qc.ca.bird_project.service.mapper;

import colval.qc.ca.bird_project.model.DTO.PostDTO;
import colval.qc.ca.bird_project.model.DTO.UserDTO;
import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.service.impl.RegionService;
import colval.qc.ca.bird_project.service.impl.UserService;
import colval.qc.ca.bird_project.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserMapper implements EntityMapper<User, UserDTO> {
    @Autowired
    private UserService userService;
    @Autowired
    private RegionService regionService;

    @Override
    public UserDTO entityToDto(User user) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return new UserDTO(
               user.getId(),
               user.getFirstName(),
               user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getGender(),
                user.getEmailAddress(),
                dateFormat.format(user.getBirthDate()),
                user.getPhone(),
                user.getPoints(),
                user.getAddress().getAddressId(),
                user.getAddress().getName(),
                user.getAddress().getPostal_code(),
                user.getAddress().getRegion().getRegionId(),
                user.getAddress().getRegion().getName()
        );
    }

    @Override
    public User DtoToEntity(UserDTO userDTO) {
        if(this.userService.readOne(userDTO.getUserId()).isPresent()){
            User user = this.userService.readOne(userDTO.getUserId()).get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setEmailAddress(userDTO.getEmailAddress());
            user.setPhone(userDTO.getPhone());
            return user;
        } else {
            Region region = this.regionService.readOne(userDTO.getRegionId()).get();
            Address address = new Address(
                    userDTO.getAddressId(),
                    userDTO.getAddress(),
                    userDTO.getPostal_Code(),
                    region
            );

            Date date = new Date();
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(userDTO.getBirthDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new User(
                    userDTO.getUserId(),
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getUserName(),
                    userDTO.getPassword(),
                    userDTO.getGender(),
                    userDTO.getEmailAddress(),
                    date,
                    userDTO.getPhone(),
                    userDTO.getPoints(),
                    new ArrayList<Post>(),
                    address
            );
        }
    }
}
