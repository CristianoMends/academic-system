google.charts.load('current', { packages: ['corechart'] });

var disciplinas = [
  { nome: 'Matemática', nota: 6.5 },
  { nome: 'Português', nota: 8 },
  { nome: 'História', nota: 7.2 },
  { nome: 'Ciências', nota: 5.5 },
  { nome: 'Inglês', nota: 9 }
];
google.charts.setOnLoadCallback(drawChart0);
function drawChart0() {

  function isAproved(grade) {
    return (grade >= 7) ? 'green' : 'red';
  }
  var array = [['Disciplina', 'Nota', { role: 'style' }, { role: 'annotation' }]]

  for (var i = 0; i < disciplinas.length; i++) {
    var disciplina = disciplinas[i];
    array.push([`${disciplina.nome}`, disciplina.nota, `${isAproved(disciplina.nota)}`, `${disciplina.nota}`]);
  }
  var data = google.visualization.arrayToDataTable(array);

  var options = {
    title: 'Tabela de notas das diciplinas (ultimo semestre)',
    legend: 'none',
    bar: { groupWidth: '95%' },
  };

  var chart = new google.visualization.ColumnChart(document.getElementById('gradeDetailChart'));
  chart.draw(data, options);
}

//-----------------------------------------------------------------------------------------------------------------

google.charts.setOnLoadCallback(drawChart1);
function drawChart1() {
  var notas = [5.6, 10, 5, 6];

  function isAproved(grade) {
    return (grade >= 7) ? 'green' : 'red';
  }
  var array = [['Semestre', 'Nota', { role: 'style' }, { role: 'annotation' }]]

  for (var i = 0; i < notas.length; i++) {
    array.push([`${i + 1}º `, notas[i], `${isAproved(notas[i])}`, `${notas[i]}`]);
  }
  var data = google.visualization.arrayToDataTable(array);

  var options = {
    title: 'Tabela de notas por semestre',
    legend: 'none',
    bar: { groupWidth: '95%' },
  };

  var chart = new google.visualization.ColumnChart(document.getElementById('gradeSemesterChart'));
  chart.draw(data, options);
}


//----------------------------------------------------------------------------------------------------------------

const selectedDisciplines = [];

document.getElementById("btnAddDisciplines").addEventListener('click',function(){
  const selectDisciplines = document.getElementById("selectDisciplines");
  const disciplineName = selectDisciplines.value;
  const table = document.getElementById('daily');

  for (let i = 1; i < table.rows.length; i++) {
    const row = table.rows[i];

    for (let j = 1; j < row.cells.length; j++) {
        const cell = row.cells[j];
        const time = table.rows[i].cells[0].textContent;
        const day = table.rows[0].cells[j].textContent;

        const checkbox = cell.querySelector('input[type="checkbox"]');

        if (checkbox !== null && checkbox.checked) {
          
          cell.textContent = `${disciplineName}`;

          const discipline = {
            day: day,
            time: time,
            name: disciplineName
        };

        // Adiciona o objeto ao array de disciplinas selecionadas
        selectedDisciplines.push(discipline);
      }
    }
  }
  console.log(selectedDisciplines); // Exibe o array com os objetos das disciplinas selecionadas
    
})

document.getElementById("btnFinish").addEventListener('click',function(){

fetch("/register/disciplines", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(selectedDisciplines)
})
.then(response => {
    if (response.ok) {
      alert('ok');
    } else {
      alert('erro');
    }
})
.catch(error => console.error("Erro ao fazer login:", error));
})

function getDisciplines(select) {
  fetch("/disciplines", {
      method: "GET",
      headers: {
          "Content-Type": "application/json"
      }
  })
  .then(response => {
      if (response.ok) {
          return response.json();
      } else {
          throw new Error('Erro ao obter disciplinas');
      }
  })
  .then(data => {
      for(d in data){
        select.innerHtml += `
        <option value="${d.name}">${d.name}</option>
        `;
      }
      console.log(data);
  })
  .catch(error => {
      console.error("Erro ao obter disciplinas:", error);
  });
}

const selectDiscipline = document.getElementById('selectDiscipline');
const gradeInput = document.getElementById('gradeInput');
function addGrade(){

  fetch("/register/disciplines", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({ name:selectDiscipline.value, grade: gradeInput.value })
})
.then(response => {
    if (response.ok) {
      alert('ok');
    } else {
      alert('erro');
    }
})
.catch(error => console.error("Erro ao fazer login:", error));
}
