/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.demo.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * ProteusApi
 *
 * @author aditya.sharat
 */

public interface ProteusApi {
  //("user.json")
  @GET
  Call<Object> getUserDataWithGet(@Url String url);
  @POST
  Call<Object> getUserDataWithPost(@Url String url);


  /*
  *   @GET
  Call<ObjectValue> getUserDataWithGet(@Url String url);
  @POST
  Call<ObjectValue> getUserDataWithPost(@Url String url);

  * */
  //@GET("styles.json")
  @GET
  Call<Object> getStylesWithGet(@Url String url);
  @POST
  Call<Object> getStylesWithPOST(@Url String url);



   /* @GET
    Call<Styles> getStylesWithGet(@Url String url);
    @POST
    Call<Styles> getStylesWithPOST(@Url String url);
*/

    // @GET("layout.json")
 @GET
 Call<Object> getLayoutWithGet(@Url String url);
  @POST
  Call<Object> getLayoutWithPOST(@Url String url);

  //@GET("layouts.json")
 /* @GET
  Call<Map<String, Layout>> getLayoutsWithGet(@Url String url);
  @POST
  Call<Map<String, Layout>> getLayoutsWithPost(@Url String url);*/

    @GET
    Call<Object> getLayoutsWithGet(@Url String url);
    @POST
    Call<Object> getLayoutsWithPost(@Url String url);
}