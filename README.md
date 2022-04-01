# Test  by Salomakhin Dmytro
Please? read the notes to startup application

1.Need to start Database from docker docker-compose up --build --force-recreate (need to start this command from root project directory)
2.Start application(after start application information ws sawed to database)
3.Check how is work fetching from data base:
        - return a selected page with selected number of elements and default sorting http://localhost:8080/cryptocurrencies/list?page=<yourData>&size=<yourData>
        - return record with the highest price of selected cryptocurrency http://localhost:8080/cryptocurrencies/max?name=<currency_name>
        - return record with the lowest price of selected cryptocurrency http://localhost:8080/cryptocurrencies/min?name=<currency_name>

