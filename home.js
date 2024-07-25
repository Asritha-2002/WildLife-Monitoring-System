let image=document.getElementById("image");
const back=document.getElementById("back");
const forward=document.getElementById("forward");
const aimg=["img2.jpg","img3.jpg"];

forward.addEventListener("click",event=>{
   event.preventDefault();
    image.src=aimg[0];
    forward.addEventListener("click",event=>{
        event.preventDefault();
        image.src=aimg[1];
    });
    back.addEventListener("click",event=>{
      event.preventDefault();
      console.log("3");
        image.src=aimg[0];
        back.addEventListener("click",event=>{
            event.preventDefault();
            image.src="img.jpg";
        })
        forward.addEventListener("click",event=>{
            event.preventDefault();
            image.src=aimg[0];
        });
    });
   
   


});


