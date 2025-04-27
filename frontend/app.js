fetch('http://localhost:8080/alunos')
  .then(response => response.json())
  .then(data => {

    console.log(data); // Ver o que veio exatamente do backend

    const clubes = {};

    data.forEach(aluno => {
      // Verifica se o aluno tem um clube associado
      const clube = aluno.clube ? aluno.clube.clu_nome : 'Sem Clube'; 
      // Se não tiver clube, coloca "Sem Clube"

      clubes[clube] = (clubes[clube] || 0) + 1;
    });

    const labels = Object.keys(clubes);
    const valores = Object.values(clubes);

    const ctx = document.getElementById('meuGrafico').getContext('2d');

    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: labels,
        datasets: [{
          label: 'Número de Alunos por Clube',
          data: valores,
          backgroundColor: 'rgba(75, 192, 192, 0.6)',
          borderColor: 'rgba(75, 192, 192, 1)',
          borderWidth: 1
        }]
      },
      options: {
        responsive: true,
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });

  })
  .catch(error => {
    console.error('Erro ao buscar alunos:', error);
  });