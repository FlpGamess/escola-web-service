// Funções de clique para os botões da navbar
function acao1() {
  alert("Você clicou no Botão 1");
}

function acao2() {
  alert("Você clicou no Botão 2");
}

function acao3() {
  alert("Você clicou no Botão 3");
}

// Criação do gráfico de barras (grafico1)
new Chart(document.getElementById('grafico1'), {
  type: 'bar', // Tipo de gráfico
  data: {
    labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril'], // Eixo X
    datasets: [{
      label: 'Vendas',
      data: [12, 19, 3, 5], // Dados para as colunas
      backgroundColor: 'rgba(128, 0, 128, 0.5)', // Cor com transparência
      borderColor: 'purple', // Cor da borda
      borderWidth: 1
    }]
  },
  options: {
    responsive: true, // Adapta ao tamanho da tela
    plugins: {
      legend: { display: true } // Exibe a legenda
    }
  }
});

// Criação do gráfico de pizza (grafico2)
new Chart(document.getElementById('grafico2'), {
  type: 'pie', // Tipo de gráfico
  data: {
    labels: ['A', 'B', 'C'], // Legendas
    datasets: [{
      label: 'Distribuição',
      data: [30, 40, 30], // Dados para os pedaços da pizza
      backgroundColor: ['#800080', '#BA55D3', '#DA70D6'] // Cores dos pedaços
    }]
  },
  options: {
    responsive: true, // Responsivo
    plugins: {
      legend: { position: 'bottom' } // Posição da legenda
    }
  }
});
