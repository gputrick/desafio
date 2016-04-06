// Get the modal
var modal = document.getElementById('vinculaCategoriaModal');

// Get the button that opens the modal
var btn = document.getElementById("vinculaCategoriaButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

var closeButton = document.getElementById("closeButton");

// When the user clicks on the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

closeButton.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}