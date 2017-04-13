[y1, Fs1] = wavread('t1.wav');
[y2, Fs2] = wavread('t2.wav');
sound(y1);
sound(y1);
sound(y1, Fs1);
sound(y2, Fs2);
t1 = [1/Fs1:1/Fs2:length(y1)/Fs1];
t2 = [1/Fs2:1/Fs2:length(y2)/Fs2];
t1 = [1/Fs1:1/Fs1:length(y1)/Fs1];
ax = subplot(2,1,1)
ax = subplot(2,1,1)
ax = subplot(2,1,2)
plot(ax1,y1,t1);
Undefined function or variable 'ax1'.
 
>> ax1 = subplot(2,1,1);
>> ax2 = subplot(2,1,2);
>> plot(ax1,y1,t1);
>> plot(ax2,y2,t2);
>> plot(ax1,t1,y1);
>> plot(ax2,t2,y2);
>> linkaxes(ax1:ax2,'x');
>> C = intersect(y1,y2);
>> plot(C);
>> plot(ax1,t1,y1);
Error using plot
Data must be a single matrix Y or a list of pairs X,Y
 
>> ax1 = subplot(2,1,1);
>> ax2 = subplot(2,1,2);
>> ax1 = subplot(3,1,1);
>> ax2 = subplot(3,1,2);
>> ax3 = subplot(3,1,3);
>> plot(ax1,t1,y1);
>> plot(ax2,t2,y2);
>> linkaxes(ax1:ax2,'x');
>> [y,Fs] = intersect(y1,y2);
>> t = [1/Fs:1/Fs:length(y)/Fs];
>> plot(ax3,t,y);
Error using plot
Vectors must be the same lengths.
 
>> figure
>> plot(t,y);
Error using plot
Vectors must be the same lengths.
 
>> audiowrite('t3.wav',y,Fs);
Error using audiowrite>validateFilename (line
317)
Cannot create file t3.wav. Permission Denied.

Error in audiowrite (line 105)
[props.filename, fileExisted] =
validateFilename( props.filename );
 
>> audiowrite('result.wav',y,Fs);
Error using audiowrite>validateFilename (line
317)
Cannot create file result.wav. Permission
Denied.

Error in audiowrite (line 105)
[props.filename, fileExisted] =
validateFilename( props.filename );
 
>> filename = 'h.wav';
>> audiowrite(filename,y,Fs);
Error using audiowrite>validateFilename (line
317)
Cannot create file h.wav. Permission Denied.

Error in audiowrite (line 105)
[props.filename, fileExisted] =
validateFilename( props.filename );
 
>> filename = 'C:\h.wav';
