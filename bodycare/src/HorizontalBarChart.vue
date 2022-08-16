<template>
  <div class="bar-box">
    <div class="bar">
      <bar-chart
        ref="barChart"
        :chartData="chart.data"
        :options="chart.options"
        id="chart"
      ></bar-chart>
    </div>
  </div>
</template>

<script>
import BarChart from "@/utils/charts/barChart.js";

export default {
  name: "bar-chart",
  components: { BarChart },
  data() {
    return {
      chart: {
        data: {
          labels: ["하나", "둘", "셋", "넷", "다섯", "여섯"],
          datasets: [
            {
              label: "",
              backgroundColor: "pink",
              pointBackgroundColor: "white",
              borderWidth: 0,
              fill: true,
              tension: 0.1,
              barPercentage: 0.7,
              data: [3, 2, 7, 5, 4, 9],
            },
          ],
        },
        options: {
          indexAxis: "y",
          plugins: {
            legend: {
              display: false,
            },
            datalabels: {
              display: false,
            },
            tooltip: {
              boxWidth: 15,
            },
          },
          scales: {
            x: {
              min: 0,
              max: 10,
              grid: {
                drawBorder: false,
                color: "black",
                lineWidth: 1,
              },
              ticks: {
                callback: (val, index) => {
                  return val !== 0 ? val : "";
                },
                padding: 3,
                stepSize: 2,
              },
            },
            y: {
              ticks: {},
              grid: {
                display: false,
              },
            },
          },
          responsive: true,
          maintainAspectRatio: false,
          animation: {
            duration: 5000,
          },
        },
      },
    };
  },
};
</script>