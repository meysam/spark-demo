import spark.Spark;

import static spark.Spark.exception;

public class Main {

    public static void main(String[] args) {
        Spark.get("/hello/:name", (request, response) -> {
            throw new Exception();
//            return "Hello: " + request.params(":name");
        });

        exception(Exception.class, (exception, request,
                                              response) -> {
            response.type("application/json");
            response.body("exception");
        });


    }

}
