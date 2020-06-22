import exception.IdNotFoundException;
import spark.Spark;

import static spark.Spark.exception;

public class Main {

    public static void main(String[] args) {
        Spark.get("/hello/:id", (request, response) -> {
            Integer id = Integer.valueOf(request.params(":id"));
            if (id != 1)
                throw new IdNotFoundException();
            return "Hello Dear Tester <3";
        });

        exception(Exception.class, (exception, request,
                                              response) -> {
            response.type("application/json");
            response.body("internal server");
        });

        exception(IdNotFoundException.class, (exception, request, response)->{
            response.type("application/json");
            response.body(exception.getMessage());
        });


    }

}
