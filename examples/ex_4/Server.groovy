// listen forever
for(ServerSocket s=new ServerSocket(36895);;){

t=s.accept()
o=t.outputStream
o<<"HTTP/1.1 "
e='\r\n'*2

d={o<<"$it$e$it"}

// read params
p=t.inputStream.newReader().readLine().split()

// 405
if(p[0]!='GET')d'405 Not Supported'else{f=new File('.',p[1])

// 404
if(!f.exists())d'404 File Not Found'else if(f.isFile()){
    // 200
    x=f.name=~/\.(.*)/
    o<<"200 OK\r\nContent-Type: ${[html:'text/html',txt:'text/plain'][!x?:x[0][1]]?:'application/octet-stream'}$e"

    try{o.bytes=f.bytes}catch(t){d"500 Server Error"}}
}

o.close()
}