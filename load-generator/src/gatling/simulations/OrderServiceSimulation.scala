package loganalysis

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class OrderServiceSimulation extends Simulation {
  val baseUrl = java.lang.System.getProperty("baseURL", "http://localhost:8082")
  val userCount = Integer.getInteger("userCount", 1)
  val httpConf = http
    .baseURL(baseUrl) // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val headers_10 = Map("Content-Type" -> "application/x-www-form-urlencoded") // Note the headers specific to a given request

  val scn = scenario("OneRequestPerUrl") // A scenario is a chain of requests and pauses
    .exec(http("log-info").get("/log/info"))
    .pause(1)
    .exec(http("log-warn").get("/log/warn"))
    .pause(1)
    .exec(http("log-error").get("/log/error"))
    .pause(1)
    .exec(http("order").get("/order"))

  setUp(scn.inject(atOnceUsers(userCount)).protocols(httpConf))
}
