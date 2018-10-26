
function getNews() {
    "use strict";
    var countrydrop = document.getElementById("country");
    var countryval = countrydrop.options[countrydrop.selectedIndex].value;
    
    var categorydrop = document.getElementById("category");
    var categoryval = categorydrop.options[categorydrop.selectedIndex].value;
    
    var keywordval = document.getElementById("keyword").value;
    var url = "https://dry-journey-57345.herokuapp.com/news";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("News/show").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", url, true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.send(JSON.stringify({country:countryval, category:categoryval, keyword:keywordval}));   
}
