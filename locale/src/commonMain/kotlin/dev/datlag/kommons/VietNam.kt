package dev.datlag.kommons


data object VietNam : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("VN")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("VNM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(704)
}