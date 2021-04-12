package colval.qc.ca.bird_project;

import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BirdProjectApplication {

    private final Logger log = LoggerFactory.getLogger(BirdProjectApplication.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private PostService postService;

    @Autowired
    private ObservedBirdService observedBirdService;

    public static void main(String[] args) {
        SpringApplication.run(BirdProjectApplication.class, args);
    }

    @Bean
    void showPosts(){
        List<Post> posts = postService.readAll();
        for (Post post: posts
             ) {
            log.info("this is a post {}", post);
        }
    }
   /* @Bean
    void createPost(){
        Region region = regionService.readOne(381).get();
        User user = userService.readOne(6).get();
        Post post = new Post(1, "This is a Cardinal", "Lorem Ipum", new Date(2021, 04, 11)
                , "C:\\Users\\Utilisateur\\Desktop\\Collégial Hiver 2021\\Développement d'application web transactionelles\\Exercices\\bird_project\\src\\main\\resources\\static\\Img", 5, new ObservedBird(), user);
        ObservedBird observedBird = new ObservedBird(1, "Cardinal", region, post);

        postService.create(post);
        observedBirdService.create(observedBird);
    }*/

    /*@Bean
    void createCountryAndRegion(){
        //Country
        Country country = new Country(1, "Canada", "CA", new ArrayList<Region>());
        Country country1 = new Country(37, "United-states", "US", new ArrayList<Region>());
        Country country2 = new Country(38, "Mexico", "MX", new ArrayList<Region>());

        //Canada region
        Region region = new Region(1, "Quebec", "QC", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region1 = new Region(2, "Newfoundland and Labrador","NL", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region2 = new Region(3, "New Brunswick","NB", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region3 = new Region(4, "Nova Scotia","NS", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region4 = new Region(5, "Prince Edward Island","PE", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region5 = new Region(6, "Ontario","ON", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region6 = new Region(7, "Manitoba","MB", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region7 = new Region(8, "Nunavut","NU", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region8 = new Region(9, "Saskatchewan","SK", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region9 = new Region(10, "Northwest Territories","NT", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region10 = new Region(11, "Alberta","AB", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region11 = new Region(12, "British Columbia","BC", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);
        Region region12 = new Region(13, "Yukon","YT", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);

        //US Region
        Region region = new Region(1, "Alabama", "AL", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region1 = new Region(2, "Alaska","AK", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region2 = new Region(3, "Arizona","AZ", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region3 = new Region(4, "Arkansas","AR", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region4 = new Region(5, "California","CA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region5 = new Region(6, "Colorado","CO", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region6 = new Region(7, "Connecticut","CT", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region7 = new Region(8, "Delaware","DE", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region8 = new Region(9, "District of Columbia","DC", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region9 = new Region(10, "Florida","FL", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region10 = new Region(11, "Georgia","GA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region11 = new Region(12, "Hawaii","HI", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region12 = new Region(13, "Idaho","ID", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region13 = new Region(14, "Illinois", "IL", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region14 = new Region(15, "Indiana","IN", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region15 = new Region(16, "Iowa","IA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region16 = new Region(17, "Kansas","KS", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region17 = new Region(18, "Kentucky","KY", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region18 = new Region(19, "Louisiana","LA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region19 = new Region(20, "Maine","ME", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region20 = new Region(21, "Maryland","MD", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region21 = new Region(22, "Massachusetts","MA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region22 = new Region(23, "Michigan","MI", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region23 = new Region(24, "Minnesota","MN", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region24 = new Region(25, "Mississippi","MS", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region25 = new Region(26, "Missouri","MO", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region26 = new Region(27, "Montana", "MT", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region27 = new Region(28, "Nebraska","NE", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region28 = new Region(29, "Nevada","NV", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region29 = new Region(30, "New Hampshire","NH", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region30 = new Region(31, "New Jersey","NJ", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region31 = new Region(32, "New Mexico","NM", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region32 = new Region(33, "New York","NY", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region33 = new Region(34, "North Carolina","NC", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region34 = new Region(35, "North Dakota","ND", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region35 = new Region(36, "Ohio","OH", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region36 = new Region(37, "Oklahoma","OK", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region37 = new Region(38, "Oregon","OR", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region38 = new Region(39, "Pennsylvania","PA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region39 = new Region(40, "Rhode Island", "RI", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region40 = new Region(41, "South Carolina","SC", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region41 = new Region(42, "South Dakota","SD", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region42 = new Region(43, "Tennessee","TN", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region43 = new Region(44, "Texas","TX", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region44 = new Region(45, "Utah","UT", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region45 = new Region(46, "Vermont","VT", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region46 = new Region(47, "Virginia","VA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region47 = new Region(48, "Washington","WA", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region48 = new Region(49, "West Virginia","WV", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region49 = new Region(50, "Wisconsin","WI", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);
        Region region50 = new Region(51, "Wyoming","WY", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country1);

        //Mexico Region

        Region region51 = new Region(52, "Mexico","MX", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country2);

        countryService.create(country1);
        countryService.create(country2);*/

        /*country.setRegions(Arrays.asList(new Region[]{region, region1, region2, region3, region4, region5, region6, region7, region8, region9, region10, region11, region12}));

        countryService.create(country);

        regionService.create(region);
        regionService.create(region1);
        regionService.create(region2);
        regionService.create(region3);
        regionService.create(region4);
        regionService.create(region5);
        regionService.create(region6);
        regionService.create(region7);
        regionService.create(region8);
        regionService.create(region9);
        regionService.create(region10);
        regionService.create(region11);
        regionService.create(region12);
        regionService.create(region13);
        regionService.create(region14);
        regionService.create(region15);
        regionService.create(region16);
        regionService.create(region17);
        regionService.create(region18);
        regionService.create(region19);
        regionService.create(region20);
        regionService.create(region21);
        regionService.create(region22);
        regionService.create(region23);
        regionService.create(region24);
        regionService.create(region25);
        regionService.create(region26);
        regionService.create(region27);
        regionService.create(region28);
        regionService.create(region29);
        regionService.create(region30);
        regionService.create(region31);
        regionService.create(region32);
        regionService.create(region33);
        regionService.create(region34);
        regionService.create(region35);
        regionService.create(region36);
        regionService.create(region37);
        regionService.create(region38);
        regionService.create(region39);
        regionService.create(region40);
        regionService.create(region41);
        regionService.create(region42);
        regionService.create(region43);
        regionService.create(region44);
        regionService.create(region45);
        regionService.create(region46);
        regionService.create(region47);
        regionService.create(region48);
        regionService.create(region49);
        regionService.create(region50);
        regionService.create(region51);

    }*/
    //adminCreation
    /*@Bean
    void createAdminUser(){
        Country country = new Country(1, "Canada", new ArrayList<Region>());

        Region region = new Region(1, "Quebec", new ArrayList<ObservedBird>(), new ArrayList<Address>(), country);

        //User admin = new User(1, "Vincent", "Chartier", "Male", "MyMail@gmail.com", new Date(1998, 01, 26), "111-111-1111", new ArrayList<Post>(), new Address());

        Address address = new Address(1, "16 Pascal Notre-Dame-de-l'île-Perrot", "J7V", admin, region);

        admin.setAddress(address);

        //userService.create(admin);

        //User getAdmin = userService.readOne(6).get();

        //log.info("admin info: {}", getAdmin.toString());
    }*/

}
