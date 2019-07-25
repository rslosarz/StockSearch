## StockSearch

### Description of the problem and solution.
StockSearch app downloads pictures from `https://api.shutterstock.com/v2/images/search` with no `query` parameter. That gives more than one million elements to scroll. The app is working in both landscape and portrait and preserves the state of list across configuration changes. Also, the app is lifecycle aware so after pausing the activity, all network calls (both via Retrofit and Glide) are cancelled.

### The reasoning behind your technical choices, including architectural.
- API calls - `Retrofit + OkHttpClient` - It's, in my opinion, the most complex library set for REST APIs on Android. I used Interceptors to provide additional headers required by the API Provider (User-Agent). Authentication is done by Basic Authentication. The reason for not using oAuth2 was only based on time shortages.

- DI - `Koin` - As I got free choice and `Dagger 2` was just a suggestion I decided to use library which I find superior - `Koin`. Personally, I have very strong feelings about `Dagger 2`. I find this library to complex and adding too much boilerplate which makes such an easy pattern like DI a remarkable effort to maintain. This is quite a long story but I think that code speaks for itself. Whenever I can I try to use `Koin` which is much simpler and way faster in both compilation and execution time. Of course `Dagger 2` has some advantages - the most important is probably the compilation time error catching. Forgetting about providing bean for some dependency on `Koin` might cause a Runtime exception. But on the other hand, having the app (not even fully) tested prevents that from happening. I also hope that this application shows how much simpler and probably cleaner is to use `Koin`.

- Fetching Images - `Glide` - This is in my opinion better choice than `Picasso`. It provides very sophisticated caching strategies, lifecycle awareness and is faster according to the sources. Also, I'm more familiar with `Glide` so it saved me some time.

- Architecture - `MVVM` - Works fine with Jetpack Paging and LiveData. Also, it's a bit better for testing purposes than eg. `MVP` which was also taken into consideration. Also `MVVM` made preserving list state easier

- Endless list - `RecyclerView + Jetpack Paging` - This is considered nowadays as a standard choice for such applications. 

- Reactiveness - `RxJava` - For such simple application using `RxJava` might be considered as a boilerplate. Nevertheless, I'm feeling more comfortable with `RxJava` than eg. `Kotlin coroutines`.

- Activity playing the role of a View and no Fragments used - For now the app has only one screen. Of course in case of implementing eg. selecting the picture and displaying some detail screen the activity would only host list and detail fragment. For such app though adding fragments looks like an overkill.

- Mocking - `MockK` - Great library which has native "kotlinish" syntax and does not have many issues from `Mockito` with mocking final, static classes or issues with creating mocks with default answers.

- JSON parser - `Gson` - Usually I prefer using `Moshi` but Gson has a bit simpler syntax which I find useful in this project.

### Trade-offs you might have made, anything you left out, or what you might do differently if you were to spend additional time on the project.
Things already implemented but not like they should bee:
1. Storing crucial data hardcoded at ApiConstants. Normally I'd use oAuth2 based authorization with secret and clientId kept on safe token server. An acceptable solution is also to use NDK or store data in KeyStore or keep them in an encrypted database. Also to defend from memory dumps it would be wise to and pass those values CharSequence objects so when no longer used we will be able to erase those data from memory.
2. Error handling, for now, is based only on logging error to the console. Some retry strategy and analytics would be necessary.

In my opinion, it's impossible to provide a "production-ready" application in 10h. The short and probably not full list of things to do:
1. Code obfuscation
2. Safe storage for API credentials (currently stored in CharSequence).
3. Code documentation - only for methods have some short "docs".
4. Adding some loader indicating data initialization.
5. Making app indexable by Google Search.
6. Adding Analytics and Crash reporting system, eg. Firebase.
7. Running Lint and some static code analysis.
8. Adding mock flavour to let developers work without working API server.
9. Adding prod, dev, test flavours to limitate usage of DI related methods inside of tests.

### Link to other code you're particularly proud of.
The code I'm really proud of is unfortunately private. I can share this app:
https://github.com/rslosarz/airadar
as the one used for several Flutter workshops I created.

### Link to your resume or public profile.
https://www.linkedin.com/in/rafa%C5%82-%C5%9Bl%C3%B3sarz-99a696113/
