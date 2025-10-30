package dev.datlag.kommons


data object Finland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("FI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("FIN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(246)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(358)
}