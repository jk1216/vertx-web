/*
 * Copyright (c) 2011-2013 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.web.client;

import io.vertx.codegen.annotations.CacheReturn;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * An HTTP response.
 * <p>
 * The usual HTTP response attributes are available:
 * <ul>
 *   <li>{@link #statusCode()} the HTTP status code</li>
 *   <li>{@link #statusMessage()} the HTTP status message</li>
 *   <li>{@link #headers()} the HTTP headers</li>
 *   <li>{@link #version()} the HTTP version</li>
 * </ul>
 * <p>
 * The body of the response is returned by {@link #body()} decoded as the format specified by the {@link BodyCodec} that
 * built the response.
 * <p>
 * Keep in mind that using this {@code HttpResponse} impose to fully buffer the response body and should be used for payload
 * that can fit in memory.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@VertxGen
public interface HttpResponse<T> {

  /**
   * @return the version of the response
   */
  @CacheReturn
  HttpVersion version();

  /**
   * @return the status code of the response
   */
  @CacheReturn
  int statusCode();

  /**
   * @return the status message of the response
   */
  @CacheReturn
  String statusMessage();

  /**
   * @return the headers
   */
  @CacheReturn
  MultiMap headers();

  /**
   * Return the first header value with the specified name
   *
   * @param headerName  the header name
   * @return the header value
   */
  @Nullable String getHeader(String headerName);

  /**
   * @return the trailers
   */
  @CacheReturn
  MultiMap trailers();

  /**
   * Return the first trailer value with the specified name
   *
   * @param trailerName  the trailer name
   * @return the trailer value
   */
  @Nullable String getTrailer(String trailerName);

  /**
   * @return the Set-Cookie headers (including trailers)
   */
  @CacheReturn
  List<String> cookies();

  /**
   * @return the response body in the format it was decoded.
   */
  @CacheReturn
  @Nullable
  T body();

  /**
   * @return the response body decoded as a {@link Buffer}
   */
  @CacheReturn
  @Nullable
  Buffer bodyAsBuffer();

  /**
   * @return the response body decoded as a {@code String}
   */
  @CacheReturn
  @Nullable
  String bodyAsString();

  /**
   * @return the response body decoded as a {@code String} given a specific {@code encoding}
   */
  @Nullable
  String bodyAsString(String encoding);

  /**
   * @return the response body decoded as a json object
   */
  @CacheReturn
  @Nullable
  JsonObject bodyAsJsonObject();

  /**
   * @return the response body decoded as the specified {@code type} with the Jackson mapper.
   */
  @Nullable
  <R> R bodyAsJson(Class<R> type);

}
