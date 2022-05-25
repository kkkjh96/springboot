/*window.onload = () => {
*
*			findAll();
		}*/
	function btnClick_Seoul()
        {
            var seoul = document.getElementById('btn_Seoul');
            var busan = document.getElementById('btn_Busan');
            seoul.style.display = 'block';
            busan.style.display = 'none';
        }
        
        function btnClick_Busan()
        {
            var seoul = document.getElementById('btn_Seoul');
            var busan = document.getElementById('btn_Busan');
            seoul.style.display = 'none';
            busan.style.display = 'block';
        }
        
        var $positions = document.querySelectorAll(".position-checkbox:checked");
        const positions = [];
		for (let i = 0; i < $positions.length; i++) {
    		positions.push($positions[i].value)
		}
		
		fetch("/positions", {
   			method: 'post',
   	 		headers: {
        		'content-type': 'application/json'
    		},
    		body : JSON.stringify({
        		positions : positions
    		})
		 })
		 
		 function getSearchList(){
			$.ajax({
				type: 'GET'
				url : "/
			})
		}