//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{  
    public class Program
    {              
    public int MaxProduct(string[] words) {
        int max = 0;
        var letters = new int[words.Length];
        for(int i=0;i<words.Length;i++){
            foreach(var ch in words[i]){
                letters[i] |= 1 << (ch - 'a');
            }
        }
        for(int i=0;i<words.Length-1;i++){
            for(int j=i+1;j<words.Length;j++){
                if ((letters[i] & letters[j]) == 0){
                    int val = words[i].Length * words[j].Length;
                    if (val > max) max = val;                    
                }                
            }
        }
        return max;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.MaxProduct(new string[]{"oimngfpnbikpaod","cekdkgemchdnndkoegm","laan","mmjlpgdjcgeoghlkkfchaadnlhhcpgh","ldcdoojc","gkcakboonkmnaonlidbmlekdnkkfgcjkbidpfamenedmd","dnoclaidjdokegealoonionkhgongaji","aliembjbpidfnjlaibjpphbajfpjh","jggkpmeoglnohdnfdmpgkhhpgbdojnl","ejehigmanmkepmfpolnjkafadaegjag","gjbpmkigahlnldhkhlogojle","kjmai","bjbpklkhhnpmpnjbfnfofojfahokifnfmonenmebjfgh","flehgmnkgpbejhdmdlgppnfaecnjoaalamjelk","eebcdjgbadijdkhhfkiglecpnhgnandnicchcmgcego","lfbhjlfecdbplobflgbd","fdcdgoikhlbbncmagmopmabkcjciioekncggnjcp","cipaggceadkkadjaeepdeocpoakadhd","dhiohambohmobagamdnigomh","gdkhobdmfbecoimaoajijkncoikfmjf","kpkbkoecahjedodofgcgfefkelc","fjhlncdfmcdaafdaddpgecmnjjadikhmjk","kmcgjna","jgmjgienkhckaoafpchcepgojabbpbkpmdgdcffloke","peioahmnedhpjdcimonieggkoeokgl","hcjkaanfejpkllelgfiikdialabmilmnmepbdlpeaccb","eaiaobfjlojmealffjhjohpjbamhahjngfhkajb","ddgfdnhjgaijcpnkkcmpkhhmehaokkapicleoijemd","ncbbljlefgdfohfof","dpekpolnfgbbeklmhbmgc","gnekohighijdi","fbmbflj","ib","ffbpnpcmidkfojccdkma","bbggnopkbggknjlogjchkhfocggmknjmdpe","gnalie","bofckpannpofi","iapohlinpbfhibojpclga","bllldjmjojjcdohnhdbkfeglnclgmojejhpnbgfana","bemhgmcicakmcangaegbehneldop","pacjmpeldm","nhcdfjcceclhjgdfmkmbmpgjoaafdphkdladcce","fnbhhcadhpblfahiakafjlkhb","dcmmpldib","ngnkdlfgffcefhmlekokbemcgikkihajbbcbindjholbdhmoajo","lglcfckkj","kgofpajbddfcfi","gchfgkcckhndgnoeabpjfjfaodbjdmi","poggemgmlihcnccgpfgjniccoldoceiocgoc","ian","enoljmjcbfldbnknlaibljcigdbnnpehkfolhmknhplc","kj","blloiifboikhalaccnakgdammlkndihekcgnpofgkehopjhpk","imggodingghdenapedlcjek","lodidhiebkahnooaiieafacihnbnkmcpalhldhdone","ghfaiknjklfooeimamdnjabgl","nbmpiopkjeicfk","cehccbjecjdipdikcpcjebbbkjldcflibeoohcgnibcndfhek","pdjanijokpajeicbobffookodgbdhflgmmefgfcjllghpkdgko","npjidipafbeclamgfgdnkjibbpafnmgcenbofidepp","djdlgpkkncfpohkclpnlpodbnhlbfokenmfhkdofkoahnb","edoaplpdckojhhpcmked","fcookjogpjnjdmhhhaliogbmllj","ifeikpppfdflhoopopmndlmkapcpkagmjgbijccfbfomb","fjgpplmaekgginkjdigfdlcchbmfhocjm","ffcieablckpfnejgailmmhbmfm","fkajdhmmgaako","njcpojncnhpgphnnfjeobeaobkoil","gdbhjpdnoophjnajnfeoajjdgihccnljohomlhdhd","gcfmjiahinghakipidpjnifjgmecpajiihb","oilklaphacgofdoaeobbghikcmfeamcjlg","idbkilgcfaffanagememfkojknncbnedjjniojbbncajol","peanbcjhadhjdcohlhdh","bfiiomhfkaabigniahfnecnlmllknincaaaagmflnmfpn","onmpaagbknmddnmnlaeggkmdjpgjdinhobngnnelcpmhe","clalhepnhnhpogkclooehd","lhnkfpechldpcdjiikjgnlebfafgokogpkdpkeakphjnbpbcngd","gkdcpgcdpkfnojdiiefjnmi","jbhokafphelnhocckcpfhkpkd","lploggahnd","fonbolmbcmdndmfoinan","lgfjodg","bdjgikdkegdimdkfd","jjeaghkdjfpopnmpdhcab","pflecenpklilpdcakpacekknabomlgphcajieam","mjpigpacpaffjnmgk","cooon","hhakohoplemllaigpjmplddhhcpglobobiocobefoe","impbieilomimgoomcbbmccmalbb","poklcofkc","pgnjoclmejbcheaahkjolbcnn","jmbjkkggmhibobkjmp","goahedpidnkdcekhniloijkoahgcepgl","oabklpbebflioo","obhhmpbldnpohgmomniofkplclh","djbgcpjjaflajeghehapdhmkgcjjoncodobokfadoigdkdhd","jhk","mklepidondimpahkfhkempf","aakjldifajchemfngkapapcff","olgbodmalbgbnanlabpaflcgcakinepnoeng","ojcg","pfdjmodmihpejcdlhdhfhdhdndaco","modkgdpemapmicoaalmpemhkojfieoonhbibhcnjpbjenpjngjf","eipfegmoooikedefnpbcmkgh","nfejeenmh","he","heebjgdchlianiibkgbohkmaajmalfga","mfjiomlpmmcclefpmccbohhjojb","lmgn","gfgimachhkcbngcaikmmjjjajfkknnpnlgdbengnch","pipbhmhgejooondfkogdiipobogkggjg","akmnbgimbpmj","eahlnjjmlfdjhmchpflbpackjmkpgleocmamggendbf","blbpfglajgmcflapkabipbpfgaehjacefiifhkfkjdcedoeg","ipfcoiblhcmaceghegildmjhboljjblomcldakegnfanonnj","ccklkpcplhnngapmnopdpfokggpgm","niflehdpjopbcfg","adhimakadilfmbggcafdngcbcoboob","dboipp","cickoafeogihecodcnbjihbhilcobcjaoeijfllk","lmkdpkdbomfmfekgjpbeamk","akojhjbokllmbaeahegefbj","fnoagckagheohhpbmhnojcfgligjikkciennlnlnehailbgni","illjnjokjffaekcoepmicimoebgeliklkalebg","imlmihcmok","jpkfejbakpecfknojihnjmaeeglkfigdlcij","hfnoikcicpagfppmcegjfdehmnfneemfg","emhepklflclpbgaenlajfenafodmkbacnighfelaeinlogfpnk","ggobha","lhnhkfnnamlapjeokn","ilikonikjbddcfnnncdieel","lkecfjckcfkcnliofcdcmeahnblk","hcdidhhdna","bghcgjgbacogcodmaipbdldphpkcbdfakjbgadjcf","fbikhejj","gfgapmpfiodinhieagoedpbalbkiicgkkdaiddeoobfdgofbag","djobamajkgnfamdmcibcimpkjmeefjhggpibpki","gfijjcdfojpkekdldbdigjhohmeejijpb","fiocebecpcpi","gbcikkgbddonhacmbjieoinifecjkdlahebjb"}));
            Console.WriteLine(p.MaxProduct(new string[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
            Console.WriteLine(p.MaxProduct(new string[]{"a", "aa", "aaaa"}));
        }
    }
}

