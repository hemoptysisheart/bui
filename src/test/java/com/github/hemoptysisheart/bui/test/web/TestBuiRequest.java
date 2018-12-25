package com.github.hemoptysisheart.bui.test.web;

import com.github.hemoptysisheart.bui.web.BuiRequest;
import com.github.hemoptysisheart.bui.web.Verb;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/20
 */
public class TestBuiRequest implements BuiRequest {
  private static final Logger log = getLogger(TestBuiRequest.class);

  public static TestBuiRequest random() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    Verb verb = List.of(Verb.values()).stream().findAny().get();
    return random(verb);
  }

  public static TestBuiRequest random(Verb verb) {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    Path path = Paths.get(IntStream.range(0, random.nextInt(10))
        .mapToObj(i -> randomAlphabetic(1, 5))
        .collect(Collectors.joining(FileSystems.getDefault().getSeparator())));
    URL url;
    try {
      url = new URL(format("%s://localhost%s",
          random.nextBoolean() ? "http" : "https",
          path));
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }

    TestBuiRequest request = new TestBuiRequest(verb, url);

    if (log.isTraceEnabled()) {
      log.trace("return : {}", request);
    }
    return request;
  }

  private Verb verb;
  private URL url;

  public TestBuiRequest(URL url) {
    this(Verb.READ, url);
  }

  public TestBuiRequest(Verb verb, URL url) {
    requireNonNull(verb);
    requireNonNull(url);

    this.verb = verb;
    this.url = url;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.web.BuiRequest
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public Verb getVerb() {
    return this.verb;
  }

  @Override
  public URL getUrl() {
    return this.url;
  }

  @Override
  public URI getUri() {
    try {
      return this.url.toURI();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Path getPath() {
    return Paths.get(getUri());
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder(TestBuiRequest.class.getSimpleName())
        .append("{verb=").append(this.verb)
        .append(", url=").append(this.url)
        .append('}').toString();
  }
}