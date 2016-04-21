
		

		//預設欄位位置
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
		//grid設定
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
			var change=gridOptions.columnApi.getColumnState();//取得目前的欄位名稱
			var newColumn=[];//要存入DB的欄位
			$.each(change,function(key,value){
				newColumn.push(value.colId);				
			})
			
			var jsonString=JSON.stringify(newColumn);
			console.log('jsonString='+jsonString);
			//呼叫ajax，將使用者的習慣存入DB
			$.post('SaveFavoriteAction.action',{'newColumn':jsonString},function(){});
		};
		//
		function getColumnName(name){
			switch(name){
				case 'buy_date':return '收料日期';
				case 'buy_no':return '採購單號';
				case 'eq_no':return '基準料號';
				case 'color':return '色號';
				case 'width':return '幅寬';
				case 'box_no':return '箱號';
				case 'cylinder_no':return '缸號';
				case 'stored':return '儲位';
				case 'amount':return '庫存量';
				case 'unit':return '庫存單位';				
			}
		}
		//頁面載入時接收資料	
		document.addEventListener('DOMContentLoaded',function(){			
			var gridDiv=document.querySelector('#myGrid');
			new agGrid.Grid(gridDiv, gridOptions);	
			//將資料塞入表格
			$.post('equipmentAction.action',{},function(data){			
				gridOptions.api.setRowData(data);					
				gridOptions.api.sizeColumnsToFit();				
			});			
			//欄位移動時觸發
			gridOptions.api.addEventListener('columnMoved',columnHandler);
			//呼叫使用者上次移動的欄位位置
			$.get('CallFavoriteAction.action',{},function(data){
				//如果使用者上次有移動才重新配置欄位
				if(data!='none'){
					var newcolumnDefs=[];
					$.each(data.split(','),function(index,value){
						newcolumnDefs.push({headerName: getColumnName(value), field: value, filter: 'text'});						
					})
					gridOptions.api.setColumnDefs(newcolumnDefs);
				}				
			})
		})

		//按下ctrl+f時聚焦到指定的地方
		function keyDown(e){
			//判斷瀏覽器
			var currKey=0,e=e||event;
			currKey=e.keyCode||e.which||e.charCode;
			//var keyName=String.fromCharCode(currKey);
			var F_KEY=70;
			if(e.ctrlKey&&currKey==F_KEY){				
				e.preventDefault();//關閉原本的ctrl+f功能
				var filter=document.getElementById('filter');
				filter.focus();//聚焦到指定的地方
			}			
		};
		document.onkeydown=keyDown;
		
		//登出
		function signOut(){			
			location.href="signout.jsp";
		}
	
	