let input = document.querySelector('input');
let textarea = document.getElementById("test");

input.addEventListener('change', () => {

    $(document).ready(function(){
        let files = input.files;
        if(files.length == 0) return;
        const file = files[0];
        let reader = new FileReader();
        reader.onload = (e) => {
            const file = e.target.result;
            const lines = file.split(/\r\n|\n/);
            var codemirror = $('.codemirror-textarea').nextAll('.CodeMirror')[0].CodeMirror;
            codemirror.getDoc().setValue(lines.join('\n'));
        };
        reader.onerror = (e) => alert(e.target.error.name);
        reader.readAsText(file); 
    });

    
    
});

 