# spark-demo
## for handling errors and exceptions in javaspark:
 you can use custom mapper for the user-defined exceptions to route the request-response objects to your custom mapper and return an appropriate response with any format which is needed. In some cases, you also can utilize built-in functions in Spark class like internalServerError and notFound.
 
 `exception(Exception.class, (exception, request,
                                                response) -> {
              response.type("application/json");
              response.body("internal server");
          });`
  
  `exception(IdNotFoundException.class, (exception, request, response)->{
              response.type("application/json");
              response.body(exception.getMessage());
          });`

#How to test:

    steps:
        send this request to get normal response:
        http://localhost:4567/hello/1
        
        send a wrong id to get IdNotFoundException:
        http://localhost:4567/hello/3
        
        send a wrong format for id to get Exception
        (internal server error due to casting String to Number)
        http://localhost:4567/hello/abc
