$(function() {
const graph = document.getElementById("graph1").getContext("2d");

Chart.defaults.global.defaultFontSize = 10;

let massPopChart = new Chart(graph, {
  type: "line", // bar, horizontalBar, pie, line, doughnut, radar, polarArea
  data: {
    labels: [
	 "janvier",
	 "février",
	 "mars",
	 "avril",
	 "Mai",
	 "Juin",
	 "Juillet",
	 "Aôut",
	 "Septembre",
	 "Octobre",
	 "Novembre",
	 "Decembre",
	 
	 
	
    ],
    datasets: [
      {
	 labels: [
        "Zohor",
        "Mebroka",
        "ElFarah",],
        data: [6, 8, 3, 4],
        backgroundColor: [
          "blue",
          "blue",
          "blue",
         
          "blue",
          
        ],
        
        hoverBorderWidth: 3,
      },
    ],
  },
  options: {
    title: {
      display: true,
      text: "Comparaison des depenses",
      fontSize: 20,
    },
    legend: {
      display: true,
    },
    // start at 0
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true,
          },
        },
      ],
    },
    layout: {
      padding: {
        left: 50,
        right: 50,
        top: 50,
      },
    },
  },
});


});

