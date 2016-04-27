
		//預設欄位位置
		var columnDefs=[
		     {headerName: "#",field:'index',filterParams:{newRowsAction:'keep'}, width: 100, cellRenderer: function(params) {
		    	 return params.node.id + 1;
		     } },
            {headerName: "收料日期", field: "rec_DATE",filterParams:{newRowsAction:'keep'}},	
            {headerName: "採購單號", field: "pur_NO",filterParams:{newRowsAction:'keep'}},	
            {headerName: "基準料號", field: "mat_01",filterParams:{newRowsAction:'keep'}},
            {headerName: "色號", field: "col_NO",filterParams:{newRowsAction:'keep'}},
            {headerName: "幅寬", field: "wid_TH",filterParams:{newRowsAction:'keep'}},
            {headerName: "箱號", field: "cnt_NO",filterParams:{newRowsAction:'keep'}},
            {headerName: "缸號", field: "lot_ID",filterParams:{newRowsAction:'keep'}},
            {headerName: "儲位", field: "loc_CODE",filterParams:{newRowsAction:'keep'}},
            {headerName: "庫存量", field: "stock_QTY",filterParams:{newRowsAction:'keep'}},
            {headerName: "庫存單位", field: "unt_RQ",filterParams:{newRowsAction:'keep'}},			
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
			//
			enableColResize:true,
		};		
		//使用者輸入篩選條件
		$('#filterButton').on('click',onFilterChanged);
		function onFilterChanged() {
			var filter=$('#filter').val();
		    gridOptions.api.setQuickFilter(filter);		  
		}
		//搜尋基準料號，色號

		$('#buyNoButton').on('click',getData);		
		function getData(){
			var MAT_01=$('#MAT_01').val();
			var COL_NO=$('#COL_NO').val();
			if(MAT_01.length==0&&COL_NO.length==0){
				$.post('INV_ITEM_Action.action',{},function(data){					
					gridOptions.api.setRowData(data);
				});
			}else{
				$.post('INV_ITEM_Action.action',{'MAT_01':MAT_01,'COL_NO':COL_NO},function(data){			
					gridOptions.api.setRowData(data);
				});	
			}
		}
		
		
		
		//欄位移動
		function columnHandler(event){
			var change=gridOptions.columnApi.getColumnState();//取得目前的欄位名稱
			var newColumn=[];//要存入DB的欄位
			$.each(change,function(key,value){

				newColumn.push(value.colId);				
			})			
			var jsonString=JSON.stringify(newColumn);

			//呼叫ajax，將使用者的習慣存入DB
			$.post('SaveFavoriteAction.action',{'newColumn':jsonString},function(){});
		};
		//
		function getColumnName(name){
			switch(name){
				case 'rec_DATE':return '收料日期';
				case 'pur_NO':return '採購單號';
				case 'mat_01':return '基準料號';
				case 'col_NO':return '色號';
				case 'wid_TH':return '幅寬';
				case 'cnt_NO':return '箱號';
				case 'lot_ID':return '缸號';
				case 'loc_CODE':return '儲位';
				case 'stock_QTY':return '庫存量';
				case 'unt_RQ':return '庫存單位';
				case 'index':return '#';
				default : return 'none';
			}
		}
		//頁面載入時接收資料
		$(function(){
			var gridDiv=document.querySelector('#myGrid');
			//建立表格
			new agGrid.Grid(gridDiv, gridOptions);
			gridOptions.api.setColumnDefs(columnDefs);
			gridOptions.api.sizeColumnsToFit();	
			//欄位移動時觸發
			gridOptions.api.addEventListener('columnMoved',columnHandler);
			//呼叫料號
			$.post('CallMAT_01Action.action',{},function(data){
				$.each(data,function(key,value){					
					$.each(value,function(index,value2){
						$('#MAT_Select').append($('<option/>').text(value2));
					})
				})
			})
			//呼叫使用者上次移動的欄位位置
			$.get('CallFavoriteAction.action',{},function(data){
				//如果使用者上次有移動才重新配置欄位
				if(data['99']!='none'){
					var newcolumnDefs=[];//新的欄位位置
					$.each(data,function(key,value){
						if(value=='index'){
							newcolumnDefs.push({headerName: getColumnName(value), field: value,filterParams:{newRowsAction:'keep'}, width: 100, cellRenderer: function(params) {
						    	 return params.node.id + 1;
						     } });
						}else{
							newcolumnDefs.push({headerName: getColumnName(value), field: value,filterParams:{newRowsAction:'keep'}});
						}
						gridOptions.api.setColumnDefs(newcolumnDefs);
						gridOptions.api.sizeColumnsToFit();											
					})
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
		//下拉選單
		$('#MAT_Select').on('change',MAT_Select);
		function MAT_Select(){
			var option=$('#MAT_Select>option:selected').text();
			$('#MAT_01').val(option);
		}