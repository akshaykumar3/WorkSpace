
public class SpojPHIDIAS {

	public static void main(String[] args){
		compute(1,21,11,4,10,4,6,2,7,5,15,10);
	}

	private static void compute(int t, int w, int h, int n, int x1, int y1,
			int x2, int y2, int x3, int y3, int x4, int y4) {
		int[][] a = new int[601][601];
		int i,j,k;
		while(t-- > 0)
		{
			for(i=0;i<=w;i++)
			{
				for(j=0;j<=h;j++)
				{
					a[i][j]=i*j;
				}
			}
			a[x1][y1]=0;
			a[x2][y2]=0;
			a[x3][y3]=0;
			a[x4][y4]=0;
			for(i=0;i<=w;i++)
			{
				for(j=0;i<=h;j++)
				{
					for(k=0;k<=i;k++)
					{
						a[i][j]=min(a[i][j], a[k][j]+a[i-k][j]);
					}
					for(k=0;k<=j;k++)
					{
						a[i][j]=min(a[i][j], a[i][k]+a[i][j-k]);
					}
				}
			}
			System.out.println(a[w][h]);
		}
	}

	private static int min(int i, int j) {
		return (i > j ? j : i);
	}
}
