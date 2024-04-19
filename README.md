<h1>Foundation Code Demo </h1>
Code will show list of images and title in recycler view
API needs to call to fetch list of data consist of title and url

<h2>Features </h2>
1. Call API and show list of images and title in recyclerview.

<h2>Evidence : </h2> 

[foundation.webm](https://github.com/siddhpatil6/foundation/assets/5618021/032aa08d-dc19-42f2-8753-68af80245c06)


<h2>Installation </h2>
Clone the repository: <br>
git clone https://github.com/siddhpatil6/foundation.git <br>
Open the project in Android Studio. <br>
Build and run the project on an emulator or a physical device. <br>

<h2>Usage </h2>
Describe how to use the app, including any prerequisites or setup required. <br>

<h2>Libraries Used </h2>

```
implementation("com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0")
implementation("com.google.dagger:hilt-android:2.51.1")
kapt("com.google.dagger:hilt-compiler:2.51.1")

// For instrumentation tests
androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")
kaptAndroidTest("com.google.dagger:hilt-compiler:2.51.1")

// For local unit tests
androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")
kaptAndroidTest("com.google.dagger:hilt-compiler:2.51.1")
```


<h2>MVVM Architecture:  </h2>
 <br>
<img width="782" alt="Screenshot 2024-04-18 at 6 55 39 PM" src="https://github.com/siddhpatil6/forthcode/assets/5618021/92acbce2-5a82-4578-a87d-f68e2e2a6596">

View :  MainAcitivity <br>
ViewModel : FoundationViewModel <br>
Domain : FoundationUseCase <br>
Repository : FoundationRepository <br>


<h2>Hilt : </h2>
Component : FoundationComponent <br>
Modules : AppModule , FoundationModule <br>

<h2>Code Overview </h2>
<h4>MainActivity: </h4> The main activity of the app. It initializes the ViewModel and observes the list of photos.
<h4>FoundationViewModel: </h4> ViewModel class responsible for fetching the list of photos from the API.
<h4>FoundationAdapter: </h4> RecyclerView adapter for displaying the list of photos.
<h4>FoundationViewModelFactory: </h4> Factory class for creating an instance of FoundationViewModel.

<h2>API Used </h2>
<h4>The app uses the following API to retrieve the list of photos: </h4>


API Base URL: https://jsonplaceholder.typicode.com <br>
Endpoint: /photos <br>
Method: GET <br>
Response Format: JSON <br>


<h1>BindingAdapter for ImageView </h1>

This BindingAdapter is used to load an image from a given URL into an ImageView using data binding. If the ImageView does not already have a drawable set, it will set a default placeholder image (ic_launcher_foreground) before asynchronously downloading and setting the image from the provided URL.

```
@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgUrl: String?) {
    // Implementation
}
```

Parameters
imgUrl: The URL of the image to load into the ImageView.

<h1>downloadBitmap : </h1> <br>
function attempts to download an image from a given URL and return it as a Bitmap. However, it's important to handle the network operations off the main UI thread to avoid blocking the UI.

