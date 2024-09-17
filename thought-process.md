# Thought Process
## Basic Requirement
### process 10k request per second
our function requirement need us to record id in memory which is quite efficient, overhead is negligible. However, optional params of endpoint require us send http request to remote endpoint, which I give an estimated latency of 10 millisecond. One thread can send 100 requests in one second, so we need a thread pool of 100 to process 10k request per second.

### support /api/verve/accept HTTP GET API
1. most convenient way of support HTTP GET API is Spring Boot Web, which is my choice.
2. return "failed" in case of any error means global error handling, which Spring Boot Web support well, too.

### flush last minute unique request count to log file
1. we need to store processed request id to ensure deduplication. For basic requirement, just use in-memory HashSet.
2. we need to implement schedule task to trigger flush every minute.
3. we need customize standard logger filter to write unique request to log file.

### fire http request to endpoint
use Spring Boot built-in WebClient to send http request to endpoint.

## Extension 1 Requirement
modify http request method to POST
## Extension 2 Requirement
ensure deduplication works in distributed system, which database does the work. I choose MySQL to store all unique id.
## Extension 3 Requirement
logback have built-in send log to kafka feature.