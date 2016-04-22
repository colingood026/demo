		gridDiv=null;
		//為了搜尋採購單號之後，清空該搜尋欄之後可以再叫出所有資料
		rowData=null;
		//預設欄位位置
		var columnDefs=[
            {headerName: "收料日期", field: "REC_DATE"},	
            {headerName: "採購單號", field: "PUR_NO"},	
            {headerName: "基準料號", field: "MAT_01"},
            {headerName: "色號", field: "COL_NO"},
            {headerName: "幅寬", field: "WID_TH"},
            {headerName: "箱號", field: "CNT_NO"},
            {headerName: "缸號", field: "LOT_ID"},
            {headerName: "儲位", field: "LOC_CODE"},
            {headerName: "庫存量", field: "STOCK_QTY"},
            {headerName: "庫存單位", field: "UNT_RQ"},			
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
			//關閉loading畫面
			suppressLoadingOverlay:true,
			//大範圍選取
			enableRangeSelection: true,
			 //當群組時會顯示目前是用哪個欄位做群組
			rowGroupPanelShow:'onlyWhenGrouping',
		};		
		//使用者輸入篩選條件
		function onFilterChanged(value) {
		    gridOptions.api.setQuickFilter(value);		  
		}
		//搜尋基準料號，色號

		$('#buyNoButton').on('click',getData);		
		function getData(){
			var MAT_01=$('#MAT_01').val();
			var COL_NO=$('#COL_NO').val();			
			$.post('INV_ITEM_Action.action',{'MAT_01':MAT_01,'COL_NO':COL_NO},function(data){
				gridOptions.api.setRowData(data);
			});	
			
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
				case 'REC_DATE':return '收料日期';
				case 'PUR_NO':return '採購單號';
				case 'MAT_01':return '基準料號';
				case 'COL_NO':return '色號';
				case 'WID_TH':return '幅寬';
				case 'CNT_NO':return '箱號';
				case 'LOT_ID':return '缸號';
				case 'LOC_CODE':return '儲位';
				case 'STOCK_QTY':return '庫存量';
				case 'UNT_RQ':return '庫存單位';	
				default : return 'none';
			}
		}
		//頁面載入時接收資料
		$(function(){
			gridDiv=document.querySelector('#myGrid');
			//建立表格
			new agGrid.Grid(gridDiv, gridOptions);
			gridOptions.api.setColumnDefs(columnDefs);
			gridOptions.api.sizeColumnsToFit();	
			//欄位移動時觸發
			gridOptions.api.addEventListener('columnMoved',columnHandler);
			//呼叫使用者上次移動的欄位位置
			$.get('CallFavoriteAction.action',{},function(data){
				//如果使用者上次有移動才重新配置欄位
				if(data!='none'){
					var newcolumnDefs=[];//新的欄位位置
					$.each(data.split(','),function(index,value){
						newcolumnDefs.push({headerName: getColumnName(value), field: value, filter: 'text'});						
					})					
					gridOptions.api.setColumnDefs(newcolumnDefs);
					gridOptions.api.sizeColumnsToFit();
				}				
			})			
		})

		//按下ctrl+f時聚焦到指定的地方
		function keyDown(e){
			//判斷瀏覽器
			var currKey=0,e=e||event;
			currKey=e.keyCode||e.which||e.charCode;
			var F_KEY=70;
			if(e.ctrlKey&&currKey==F_KEY){				
				e.preventDefault();//關閉原本的ctrl+f功能
				var filter=$('#filter');
				filter.focus();//聚焦到指定的地方
				//加亮搜尋框，1秒後回復原狀
				filter.addClass('filterShow');
				var timeOut=setTimeout(function(){
					filter.removeClass('filterShow');
				},500);
			}			
		};
		document.onkeydown=keyDown;
		//excel
		function onBtExport(){
			var params={};
			gridOptions.api.exportDataAsCsv(params);
		}
		//登出
		function signOut(){			
			location.href="signout.jsp";
		}
	
	