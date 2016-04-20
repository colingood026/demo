		var columnDefs=[
            {headerName: "收料日期", field: "buy_date", filter: 'text'},	
            {headerName: "採購單號", field: "buy_no", filter: 'text'},	
            {headerName: "基準料號", field: "eq_no", filter: 'text'},
            {headerName: "色號", field: "color", filter: 'text'},
            {headerName: "幅寬", field: "width", filter: 'text'},
            {headerName: "箱號", field: "box_no", filter: 'text'},
            {headerName: "缸號", field: "cylinder_no", filter: 'text'},
            {headerName: "儲位", field: "stored", filter: 'text'},
            {headerName: "庫存量", field: "amount", filter: 'text'},
            {headerName: "庫存單位", field: "unit", filter: 'text'},			
		];
		
		
		
		var gridOptions={
		    columnDefs: columnDefs,
		    //排序
		    enableSorting: true,
		    sortingOrder: ['desc','asc',null],
			//篩選
			enableFilter: true,
			//點選一整行
			rowSelection: 'multiple',	     
		};
		
		
		//使用者輸入篩選條件
		function onFilterChanged(value) {
		    gridOptions.api.setQuickFilter(value);
		}				
		
		
		//輸出excel
		function onBtExport(){
			var params={};			
			gridOptions.api.exportDataAsCsv(params);
		}
		
		//欄位移動
		function columnHandler(event){
		
			
			console.log('event='+event);
			
			var xhr=new XMLHttpRequest();
//			xhr.open('GET','FavoriteAction.action?allColumns='+allColumns,true);
//			xhr.send();
//			xhr.onreadystatechange=function(){
//				if(xhr.readyState==4&&xhr.status==200){
//					console.log('jok');
//				}
//			}
		};
		
	
		
		//----改變欄位測試---
		var bt=document.getElementById('bt');
		bt.addEventListener('click',function(){			
			var newcolumnDefs=[
                {headerName: "收料日期", field: "buy_date", filter: 'text'},	
                {headerName: "採購單號", field: "buy_no", filter: 'text'},	
                {headerName: "基準料號", field: "eq_no", filter: 'text'},               
                {headerName: "箱號", field: "box_no", filter: 'text'},
                {headerName: "缸號", field: "cylinder_no", filter: 'text'},
                {headerName: "儲位", field: "stored", filter: 'text'},
                {headerName: "庫存量", field: "amount", filter: 'text'},
                {headerName: "庫存單位", field: "unit", filter: 'text'},
                {headerName: "色號", field: "color", filter: 'text'},
                {headerName: "幅寬", field: "width", filter: 'text'},
    		];			
			gridOptions.api.setColumnDefs(newcolumnDefs);
			gridOptions.api.sizeColumnsToFit();
		});
		
		//頁面載入時接收資料	
		document.addEventListener('DOMContentLoaded',function(){			
			var gridDiv=document.querySelector('#myGrid');
			new agGrid.Grid(gridDiv, gridOptions);
			var xhr=new XMLHttpRequest();
			xhr.open('GET','equipmentAction.action',true);
			xhr.send();
			xhr.onreadystatechange=function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					var data=JSON.parse(xhr.responseText);
					
					//將資料塞入表格
					gridOptions.api.setRowData(data);					
					gridOptions.api.sizeColumnsToFit();
					//欄位移動
					gridOptions.api.addEventListener('columnMoved',columnHandler);
					
					
					
					
				}
			}
		})
	
		//鍵盤紀錄		
		function keyDown(e){
			//判斷瀏覽器
			var currKey=0,e=e||event;
			currKey=e.keyCode||e.which||e.charCode;
			//var keyName=String.fromCharCode(currKey);
			
			if(e.ctrlKey&&currKey==70){				
				e.preventDefault();//關閉原本的ctrl+f功能
				var filter=document.getElementById('filter');
				filter.focus();//按下ctrl+f時聚焦到指定的地方
			}			
		};
		document.onkeydown=keyDown;
		
		//登出
		function signOut(){			
			location.href="signout.jsp";
		}
	
	