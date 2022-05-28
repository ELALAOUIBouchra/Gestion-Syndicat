$(function() {
const graph = document.getElementById("graph").getContext("2d");

Chart.defaults.global.defaultFontSize = 10;

let massPopChart = new Chart(graph, {
  type: "pie", // bar, horizontalBar, pie, line, doughnut, radar, polarArea
  data: {
    labels: [
	"sécurité",
      "eau",
     
      
      "menage",
      
       "Arrosage",
       "categorie",
      
    ],
    datasets: [
      {
        label: "Population en M ",
        data: [6, 8, 3, 4,2],
        // backgroundColor: "blue",
        backgroundColor: [
          "white",
          "blue",
          "greay",
         
          "aqua",
          "beige",
          
        ],
        hoverBorderWidth: 3,
      },
    ],
  },
  options: {
    title: {
      display: true,
      text: "Répartition des depenses",
      fontSize: 24,
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

