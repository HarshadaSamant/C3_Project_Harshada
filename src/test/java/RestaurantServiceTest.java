import org.junit.jupiter.api.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


class RestaurantServiceTest {

    RestaurantService service = new RestaurantService();
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE


    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() {
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",LocalTime.parse("10:30:00"),LocalTime.parse("22:00:00"));
        service.findRestaurantByName("Amelie's cafe");
    }

    //You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() {
        //WRITE UNIT TEST CASE HERE
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",LocalTime.parse("10:30:00"),LocalTime.parse("22:00:00"));
        service.findRestaurantByName("Amelie's cafe");
        assertThrows(restaurantNotFoundException.class,()-> {
            service.findRestaurantByName("Pantry d'or");
        });
    }
    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>




    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() {
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",LocalTime.parse("10:30:00"),LocalTime.parse("22:00:00"));
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants-1, service.getRestaurants().size());
    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception(){
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",LocalTime.parse("10:30:00"),LocalTime.parse("22:00:00"));
        assertThrows(restaurantNotFoundException.class,()->service.removeRestaurant("Pantry d'or"));
    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",LocalTime.parse("10:30:00"),LocalTime.parse("22:00:00"));
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1,service.getRestaurants().size());
    }
    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>
}