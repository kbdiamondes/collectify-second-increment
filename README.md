# Changelogs
_Provided by Keith Brylle Diamante_

## Mapping Names
- Removed the keyword **PAGE** from each RequestMapping endpoint per entities (Client/Reseller/Collector)
- Added GET METHOD Specifically for **Reseller/Collector by ID & Username**

## Additions
- FileDB (Entity)
- FileStorageService
- FileStorageServiceImpl
- FileController
- ResponseFile
- ResponseMessage

## File Upload and Download API Documentation

_This documentation provides details on how to use the File Upload and Download API endpoints of this project.
API Endpoints_

### Upload a File
```
    URL: /upload
    HTTP Method: POST
    Description: Upload a file to the server in Base64 format.
```
Request Parameters
```
    base64Image (String, required): The Base64-encoded image data.
    fileName (String, required): The name of the file.
    contentType (String, required): The content type of the file (e.g., "image/png", "application/pdf").
```
![image](https://github.com/francisjas/kahukov2/assets/68324799/526df130-93a9-4687-b302-c16c2c6d9fc4)

Sample Request (Postman)
- Open Postman.
- Create a new POST request.
- Set the request URL to http://your-api-url/upload.
- In the request body, select "form-data."
- Add the following key-value pairs:
- base64Image: [Paste your Base64-encoded image data]
- fileName: [Specify the file name]
- contentType: [Specify the content type]
- Click "Send" to upload the file.

Response
- If the upload is successful, you will receive an HTTP 200 OK response with a success message.
- If there is an error, you will receive an HTTP 417 Expectation Failed response with an error message.

### List Files
```
    URL: /files
    HTTP Method: GET
    Description: Retrieve a list of all uploaded files.
```

Sample Request (Postman)
- Open Postman.
- Create a new GET request.
- Set the request URL to http://your-api-url/files.
- Click "Send" to retrieve the list of files.

Response
- You will receive an HTTP 200 OK response with a JSON array containing details of all uploaded files.

### Download a File by ID
```
    URL: /files/{id}
    HTTP Method: GET
    Description: Download a file by specifying its unique ID.
```
![image](https://github.com/francisjas/kahukov2/assets/68324799/db175259-cd3b-4434-b219-fe5a81382946)

Sample Request (Postman)
- Open Postman.
- Create a new GET request.
- Set the request URL to http://your-api-url/files/{id} (Replace {id} with the actual ID of the file you want to download).
- Click "Send" to download the file.

Response
- You will receive the file as a downloadable attachment with the appropriate content type.

### Download a File by Filename
```
    URL: /filename/{filename}
    HTTP Method: GET
    Description: Download a file by specifying its filename.
```
![image](https://github.com/francisjas/kahukov2/assets/68324799/98cc6828-d46b-454c-a42a-f58d0d728015)


Sample Request (Postman)
- Open Postman.
- Create a new GET request.
- Set the request URL to http://your-api-url/filename/{filename} (Replace {filename} with the actual filename you want to download).
- Click "Send" to download the file.

Response
- You will receive the file as a downloadable attachment with the appropriate content type.
