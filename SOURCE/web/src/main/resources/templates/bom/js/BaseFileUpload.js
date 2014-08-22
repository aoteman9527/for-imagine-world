/**
 * Created by letuan on 6/10/14.
 */

function BaseFileUpload(){
    this.file ;
    this.url ;
    this.successFunc ;
    this.waitingFunc ;
    this.errorFunc ;

    this.setChooserEvent=function(inputElement){
        var self = this;

        $(inputElement).on('change', this.prepareUpload);
    };



    /**
     *
     * @param inputElement html element for adding event
     * @param url
     * @param successFunc
     * @param errorFunc
     */
    this.setUploadingFileEvent=function(inputElement,url,successFunc,errorFunc){

    }

    this.init = function(inputFile,inputSubmit,url,successFunc,waitingFunc,errorFunc){
        if(jQuery.isEmptyObject(inputFile)){
            throw new Error("inputFile null");
        }
        this.url= url;
        this.successFunc= successFunc;
        this.waitingFunc= waitingFunc;
        this.errorFunc= errorFunc;

        if(jQuery.isEmptyObject(inputSubmit)){
            //one event for all action
            $(inputFile).on('change', function(event){
                this.prepareUpload(event);
                this.uploadFiles(event);
                this.waitingFunc();
            });

        }else{
            //seperate two action
        }
    }

    this.prepareUpload = function(event)
    {
        files = event.target.files;
    }

    this.uploadFiles = function(event){
        event.stopPropagation(); // Stop stuff happening
        event.preventDefault(); // Totally stop stuff happening

        // START A LOADING SPINNER HERE

        // Create a formdata object and add the files
        var data = new FormData();
        $.each(files, function(key, value)
        {
            data.append("file", value);
        });

        $.ajax({
            url: this.url,
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',// this is the content-type of back-end response
            processData: false, // Don't process the files
            contentType: false, // Set content type to false as jQuery will tell the server its a query string request
            success: this.successFunc,
            error: this.errorFunc
        });
    }
}