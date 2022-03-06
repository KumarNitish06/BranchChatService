# BranchChatService

Hi,

Tech stack used: Java, Spring framework, maven, h2 database.

Workflow:
1. The agent will see first screen where he has to login/register. (Apis 1.1 and 1.2)
2. After login, agent will check all the unresolved chats. using api 4.1.
3. Agent will click on one chat from the list call the api 
		i) 3.1 to load Chat
		ii) 4.2 to assignHimself to the chat
4. Agent can fetch userInformation using api 2.1
5. Api 3.1 will agent all the chat history.
6. Agent and user will hit.
		i)api 3.2 to sendMessage.
		ii) api 3.1 to loadChat simultaneously.


Note: 1. The Db has foriegn key constraint enabled. You need to register agent before using it.

2. LoadChat api loads the chat in sorted order of their timestamp. 

3. Didn't use lombok as it requires db side setup.

4. Date provided in the csv is already loaded.

5. Connect to h2 database using link. http://localhost:8080/h2
		JDBC Url: jdbc:h2:mem:testdb
		Username: sa
		Password: <empty>

Things could be added here.
1. Logging framework
2. LoadChat can be optimized to load delta information rather than loading whole chat. We can use timestamp to achieve that.
i.e, load all the chats after this timestamp.



Agent Apis:

1.1 curl --location --request POST 'localhost:8080/agent/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "meenal"
}'

1.2 curl --location --request GET 'http://localhost:8080/agent/login/1' \
--data-raw ''

User Apis:
2.1 curl --location --request GET 'http://localhost:8080/user/8014' \
--data-raw ''

chat Api:
3.1 curl --location --request GET 'http://localhost:8080/chat/loadChat/208' \
--data-raw ''

3.2 curl --location --request POST 'http://localhost:8080/chat/sendMessage' \
--header 'Content-Type: application/json' \
--data-raw '  {
        "userId": "208",
        "agentId": 1,
        "message": "Happy to help",
        "messageTime": "2017-02-02T13:51:58.000+00:00",
        "userMessage": false
    }'



Window Api:
4.1 curl --location --request GET 'http://localhost:8080/window/unresolved' \
--data-raw ''

4.2 curl --location --request PUT 'http://localhost:8080/window/assignAgent' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "8014",
    "agentId": "1"
}'







